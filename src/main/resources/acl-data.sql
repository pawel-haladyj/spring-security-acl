INSERT INTO product (id, name, price) values
(1,'beer', 10),
(2,'chocolate', 20);
/*id, name, price*/

INSERT INTO acl_sid (id, principal, sid) VALUES
(1, 1, 'john'),
(2, 1, 'bill');
/*id, 1=user/other=roole(group), user_name(the way it is identified)*/

INSERT INTO acl_class (id, class) VALUES
(1, 'pl.haladyj.springsecurityacl.entity.Product');
/*id,class - location*/

INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES
(1, 1, 1, NULL, 1, 0),
(2, 1, 2, NULL, 2, 0);
/*id,
object_id_class = FK acl_class.id
object_id_identity = id of subsequent instances of the object described in the column above
parent_object = parent obbject id (if exist)
owner_sid = FK acl_sid.id, własciciel
entries_inheriting = czy wykonywać 1=enabled inhariting on "null column"/0=disabled*/


INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES
(1, 1, 1, 1, 1, 1, 1, 1),
(2, 1, 2, 1, 2, 0, 1, 1),
(3, 2, 1, 1, 1, 1, 1, 1),
(4, 2, 2, 1, 2, 1, 1, 1);
/*
id,
acl_object_identity = FK acl_object_identity.id supbsequent Product ids
ace_order = kolejność występowania, większe numery zasłaniają mniejsze
sid = FK acl_sid.id - USER
mask = 1 - read/ 2 - write
audit_success = 1enabled/0disabled
audit_failure = 1enabled/0disabled*/
