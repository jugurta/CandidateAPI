package com.extia.services.api.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteById(long id) {
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

    public void deletesCandidatesByIds(long [] ids)
}
