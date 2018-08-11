package mx.ipn.cic.eleven.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.eleven.entities.UserEntity;

@Repository
public interface IUserRepository extends MongoRepository<UserEntity, String>{

	UserEntity findByUserNameAndPassword(String userName, String password);
}
