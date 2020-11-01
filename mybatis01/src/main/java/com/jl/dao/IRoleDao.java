package com.jl.dao;

import com.jl.bean.Role;

import java.util.List;

public interface IRoleDao {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
