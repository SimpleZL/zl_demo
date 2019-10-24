package com.zl.spring.data.jpa.repository;

import com.zl.spring.data.jpa.model.VerityCertModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-07-10
 */
public interface VerifyCertDao extends CrudRepository<VerityCertModel, Integer> {
}
