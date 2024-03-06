package com.blancspace.userrewardsservice.repository;

import com.blancspace.userrewardsservice.entity.RuleSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RuleSetRepository extends JpaRepository<RuleSet, Integer> {

    @Query("SELECT r FROM RuleSet r WHERE r.isActive = true AND r.batchId = :batchId")
    List<RuleSet> findActiveRuleSetByBatchId(@Param("batchId") String batchId);
}