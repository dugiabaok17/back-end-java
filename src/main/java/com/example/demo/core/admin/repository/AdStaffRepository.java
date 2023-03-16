package com.example.demo.core.admin.repository;

import com.example.demo.core.admin.model.response.StaffResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface AdStaffRepository extends JpaRepository<StaffResponse,Long> {

    @Query(value = "select s.id, s.surname,s.middle_name,s.name,s.address,s.email,s.gender,s.phone_number,s.status,s.date_of_birth,p.name position_name,st.name store_name " +
            "from staff s" +
            " left join position p on p.id = s.position_id  " +
            "join store st on s.store_id = st.id where s.status = 1 order by s.id desc ", nativeQuery = true)
    Collection<StaffResponse> getAllStaff();

    @Query(value = "select s.id, s.surname,s.middle_name,s.name,s.address,s.email,s.gender,s.phone_number,s.status,s.date_of_birth,p.name position_name,st.name store_name " +
            "from staff s" +
            " left join position p on p.id = s.position_id  " +
            "join store st on s.store_id = st.id where  s.id = :id", nativeQuery = true)
    Optional<StaffResponse> findByStaff(@Param("id") Long id);

}
