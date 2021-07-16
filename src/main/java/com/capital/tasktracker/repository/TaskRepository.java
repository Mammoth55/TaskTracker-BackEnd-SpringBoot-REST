package com.capital.tasktracker.repository;

import com.capital.tasktracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("FROM Task t where (t.status = 'CREATED' OR t.status = 'WORKING') ORDER BY t.priority desc")
    List<Task> findAllActualAndPriority();

    @Query("FROM Task t where (t.text like %?1%) or (t.title like %?1%)")
    List<Task> findAllByQuery(String query);

    @Query(value = "SELECT * FROM tasks t where DATE_FORMAT(t.time,'%Y-%m-%d') = ?1", nativeQuery = true)
    List<Task> findAllByDate(String date);
}