package com.example.dao;

import com.example.domain.Policy;

import java.util.List;

public interface IPolicyDao {
    public void save(Policy policy);
    public void delete(int policyUid);
    public void update(int policyUid, Policy policy);
    public Policy get(int policyUid);
    public List<Policy> getAll();
}
