package com.devicehive.core.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;


/**
 * @param <T>
 * @param <ID>
 * @ClassName    : GenericJpaRepository
 * @Package        ：com.soyotec.core.dao
 * @Author angelos 545960677@qq.com
 * @Create Time    ：2017年3月9日 下午6:54:39
 * @Description    : 自定义DAO层的封装接口
 */
@NoRepositoryBean
public interface GenericJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
