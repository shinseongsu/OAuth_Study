create table oauth_client_details (
	client_id VARCHAR(256) primary key,
    resource_ids varchar(256),
    client_secret varchar(256),
    scope varchar(256),
    authorized_grant_types varchar(256),
    web_server_redirect_uri varchar(256),
    authorities varchar(256),
    access_token_validity integer,
    refresh_token_validity integer,
    additional_information varchar(4096),
    autoapprove varchar(256)
);

drop table oauth_client_details;

create table oauth_access_token (
	token_id varchar(256),
    token long varbinary,
    authentication_id varchar(256) primary key,
    user_name varchar(256),
    client_id varchar(256),
    authentication long varbinary,
    refresh_token varchar(256)
);


create table oauth_approvals (
	userId varchar(256),
    clientId varchar(256),
    scope varchar(256),
    status varchar(256),
    expiresAt TIMESTAMP,
    lastModifiedAt timestamp
);

create table oauth_refresh_token (
	token_id varchar(256),
    token long varbinary,
    authentication long varbinary
);

insert into oauth_client_details ( client_id,
								   resource_ids,
                                   client_secret,
                                   scope,
                                   authorized_grant_types,
                                   web_server_redirect_uri,
                                   authorities,
                                   access_token_validity,
                                   refresh_token_validity,
                                   additional_information,
                                   autoapprove
								) values (
									'clientapp',
                                    null,
                                    '123456',
                                    'read_profile,read_posts',
                                    'authorization_code',
                                    'http://localhost:9000/callback',
                                    'null',
                                    3000,
                                    -1,
                                    null,
                                    false
                                );

update oauth_client_details
   set client_secret = '$2a$10$ex7ff1WOv9wZkPgRH/Bcc.raypBGVijD6iDi2qOD7vcRngjwzeW62'
 where client_id = 'clientapp';

commit;