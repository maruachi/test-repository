package com.goodchalk.goodpass.domain.repository;

import com.goodchalk.goodpass.domain.model.ClimbingGym;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClimbingGymRepositoryImpl implements ClimbingGymRepository{
    private final ClimbingGymJdbcRepository climbingGymJdbcRepository;

    @Override
    public ClimbingGym save(ClimbingGym climbingGym) {
        return climbingGymJdbcRepository.save(climbingGym);
    }

    @Override
    public Optional<ClimbingGym> findById(Long climbingGymId) {
        return climbingGymJdbcRepository.findById(climbingGymId);
    }

    @Override
    public void deleteAll() {
        climbingGymJdbcRepository.deleteAll();
    }

    @Override
    public Iterable<ClimbingGym> findAll() {
        return climbingGymJdbcRepository.findAll();
    }

    @Override
    public Optional<ClimbingGym> findByClimbingGymName(String climbingGymName) {
        return climbingGymJdbcRepository.findByClimbingGymName(climbingGymName);
    }
}
