package com.ssgh.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

public class UdpClient {
    public static Integer SPORT = 1111;
    public static Integer DPORT = 8881;

    public static void main(String[] args) {

        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(group).channel(NioDatagramChannel.class).option(ChannelOption.SO_BROADCAST, true)
                .handler(new ChannelInitializer<NioDatagramChannel>() {

                    @Override
                    protected void initChannel(NioDatagramChannel ch) throws Exception {
                        // TODO Auto-generated method stub
                        ch.pipeline().addLast(new UdpClientHandler());
                    }
                });
        try {
            Channel channel = bootstrap.bind(SPORT).sync().channel();
            InetSocketAddress remoteAddress = new InetSocketAddress("121.248.51.112", DPORT);//121.248.51.112 8881
            for (int i = 0; i < 5; i++) {
                TimeUnit.SECONDS.sleep(1);
                String msg = "send " + i;

                ByteBuf byteBuf1 = new UnpooledByteBufAllocator(false).buffer();
                byteBuf1.writeCharSequence(msg, Charset.forName("utf-8"));
                DatagramPacket packet = new DatagramPacket(byteBuf1, remoteAddress);
                channel.writeAndFlush(packet);
                System.out.println(msg);
            }
            channel.closeFuture().sync();
            group.shutdownGracefully();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
