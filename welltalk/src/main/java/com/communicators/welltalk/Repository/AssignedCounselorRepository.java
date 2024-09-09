package com.communicators.welltalk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.communicators.welltalk.Entity.AssignedCounselorEntity;

@Repository
public interface AssignedCounselorRepository extends JpaRepository<AssignedCounselorEntity, Integer> {
}
