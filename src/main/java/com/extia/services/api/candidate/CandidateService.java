package com.extia.services.api.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> getAll() {
        return this.candidateRepository.findAll();
    }

    public Optional<Candidate> getById(long id) {
        return this.candidateRepository.findById(id);
    }

    public void deleteCandidateById(long id) {
        this.candidateRepository.deleteById(id);
    }

    public Candidate insertCandidate(Candidate candidate)
    {
        return this.candidateRepository.save(candidate);
    }

    public List<Candidate> insertCandidates(List<Candidate> candidates)
    {
        return this.candidateRepository.saveAll(candidates);
    }

    public void deletesCandidates(List<Candidate> candidates)
    {
        List<Long> candidate_ids = new ArrayList<>();
        candidates.forEach(candidate -> candidate_ids.add(candidate.getId()));
        this.candidateRepository.deleteCandidatesWithIds(candidate_ids);

    }
}
