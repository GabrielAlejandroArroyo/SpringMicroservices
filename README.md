# SpringMicroservices


### Query de views

The following Guide ilustrate SQL


```sql
SELECT
u.username,
r.role_name AS role_name,
p.name AS permission_name
FROM
users u
INNER JOIN
user_roles ur ON u.id = ur.user_id
INNER JOIN
roles r ON ur.role_id = r.id
INNER JOIN
role_permissions rp ON r.id = rp.role_id
INNER JOIN
permissions p ON rp.permission_id = p.id;

```



#### Lista de usuarios con sus respectivos Roles y permisos

| Usuario | Rol        | Permiso  |
|---------|------------|----------|
| santiago| ADMIN      | READ     |
| santiago| ADMIN      | DELETE   |
| santiago| ADMIN      | UPDATE   |
| santiago| ADMIN      | CREATE   |
| daniel  | USER       | READ     |
| daniel  | USER       | CREATE   |
| andrea  | INVITED    | READ     |
| andrea  | INVITED    | DELETE   |
| andrea  | INVITED    | UPDATE   |
| andrea  | INVITED    | CREATE   |
| anyi    | DEVELOPER  | READ     |
| anyi    | DEVELOPER  | DELETE   |
| anyi    | DEVELOPER  | UPDATE   |
| anyi    | DEVELOPER  | CREATE   |
| anyi    | DEVELOPER  | REFACTOR |
