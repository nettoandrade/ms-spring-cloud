package com.matec.hrworker.repositories;

import com.matec.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Long> {

}
