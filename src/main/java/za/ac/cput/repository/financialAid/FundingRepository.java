package za.ac.cput.repository.financialAid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.financialAid.Funding;

@Repository
public interface FundingRepository extends JpaRepository<Funding, String>
{
}
