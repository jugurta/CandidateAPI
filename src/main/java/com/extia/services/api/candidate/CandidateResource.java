package com.extia.services.api.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class CandidateResource {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/candidates")
    public ResponseEntity<List<Candidate>> getAllCandidates() {

        try {
            List<Candidate> candidateData = candidateService.getAll();
            return new ResponseEntity<>(candidateData, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Get single resource by ID  GET /api/resources/{id}
    @GetMapping("/candidates/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") long id) {
        Optional<Candidate> candidateData = candidateService.getById(id);
        if (candidateData.isPresent()) {
            return new ResponseEntity<Candidate>(candidateData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/candidates")
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
        try {
            Candidate candidateData = candidateService.insertCandidate(candidate);
            return new ResponseEntity<>(candidateData, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/candidates/many")
    public ResponseEntity<List<Candidate>> createCandidates(@RequestBody List<Candidate> candidates) {
        try {
            List<Candidate> candidateData = candidateService.insertCandidates(candidates);
            return new ResponseEntity<>(candidateData, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/candidates/{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable("id") long id, @RequestBody Candidate candidate) {
        Optional<Candidate> candidateData = candidateService.getById(id);

        if (candidateData.isPresent()) {
            Candidate _candidate = candidateData.get();
            return new ResponseEntity<>(candidateService.insertCandidate(_candidate), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/candidates/{id}")
    public ResponseEntity<HttpStatus> deleteCandidate(@PathVariable("id") long id) {
        try {
            candidateService.deleteCandidateById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/candidates/many")
    public ResponseEntity<HttpStatus> deleteCandidates(@RequestBody List<Candidate> candidates) {
        try {
            candidateService.deletesCandidates(candidates);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}




