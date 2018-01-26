package com.projekt.ai.dal.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Lenovo on 2017-11-05.
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
