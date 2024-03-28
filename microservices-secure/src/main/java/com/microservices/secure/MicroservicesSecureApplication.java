package com.microservices.secure;

import com.microservices.secure.persistence.entity.PermissionEntity;
import com.microservices.secure.persistence.entity.RoleEntity;
import com.microservices.secure.persistence.entity.RoleEnum;
import com.microservices.secure.persistence.entity.UserEntity;
import com.microservices.secure.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicesSecureApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesSecureApplication.class, args);
	}

	// Levantado de usuarios por defecto / se ejecuta al levantarse la aplicacion
	@Bean
	CommandLineRunner init (UserRepository userRepository){
		return  args ->{
			/*PRIMERO CREO LOS PERMISOS*/

			/*CREATE PERMISIONS*/
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			/*READ PERMISION */
			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			/*UPDATE PERMISION */
			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			/*DELETE PERMISION */
			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			/*REFACTOR PERMISION */
			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();


			/*SEGUNDO CREO LOS PERMISOS */
			/* A los roles les asigno los Permisos */

			/*CREATE ROLES */

			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionEntityList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionEntityList(Set.of(createPermission, readPermission))
					.build();

			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionEntityList(Set.of(readPermission))
					.build();

			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionEntityList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
					.build();


			/*TERCERO CREO LOS USUARIOS */
			/* A los usuarios les asigno los roles */

			UserEntity userSantiago = UserEntity.builder()
					.username("santiago")
					//.password("1234")
					.password("$2a$10$aEBYDsegXU89UwiC1fHcLOX03LxM.OxqNKF/aVkWVNe2voclvGr0u")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userDaniel = UserEntity.builder()
					.username("daniel")
					//.password("1234")
					.password("$2a$10$aEBYDsegXU89UwiC1fHcLOX03LxM.OxqNKF/aVkWVNe2voclvGr0u")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userAndrea = UserEntity.builder()
					.username("andrea")
					//.password("1234")
					.password("$2a$10$aEBYDsegXU89UwiC1fHcLOX03LxM.OxqNKF/aVkWVNe2voclvGr0u")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			UserEntity userAnyi = UserEntity.builder()
					.username("anyi")
					//.password("1234")
					.password("$2a$10$aEBYDsegXU89UwiC1fHcLOX03LxM.OxqNKF/aVkWVNe2voclvGr0u")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();


			/*CUARTO GUARDO LOS USUARIOS y como es en cascade crea los roles y los permisos*/
			userRepository.saveAll(List.of(userSantiago,userDaniel,userAndrea,userAnyi));

		};

	}

}
