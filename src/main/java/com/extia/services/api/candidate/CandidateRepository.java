package com.extia.services.api.candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CandidateRepository  extends JpaRepository<Candidate,Long> {

    @Modifying
    @Transactional
    @Query("delete from Candidate candidate where candidate.id in ?1")
    void deleteCandidatesWithIds(List<Long> ids);


}
