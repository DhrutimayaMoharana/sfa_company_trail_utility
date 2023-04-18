package com.watsoo.sfa.trial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.watsoo.sfa.trial.model.TrialUserDetails;

public interface TrialUserDetailsRepository extends JpaRepository<TrialUserDetails, Long> {

	@Query(value = "select * from trial_user_details where email=?1 or email in (?2)", nativeQuery = true)
	List<TrialUserDetails> findByAdminEmailAndUserEmail(String adminEmail, String[] userEmail);

	@Query(value = "select * from trial_user_details where company_id in (?1)", nativeQuery = true)
	List<TrialUserDetails> findByCompanyId(List<Long> companyIds);

}
