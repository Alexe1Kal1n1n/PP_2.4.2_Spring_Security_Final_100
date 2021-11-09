INSERT INTO kata_db.users (email,name,lastName,password,username)
VALUES
('alex@mail.ru','Alex','Kalinin','$2a$10$GGRd0oT3kI6DJFzZB3HTW./zOCTnAPg12.vBItGIS8akLG1GrvgeO','alex'),
('tregulov@ya.ru','Zaur','Tregulov','$2a$10$T9t.0r7MY//aEhB8/Nuv.eQmhnn0io1VgaWw7u8YDsjLFdbMf87Ia','zaur'),
('kim5@chen.com','Kim','ChenIn','$2a$10$GfEUbTFPYnwF.ARzKqDkh.4ybziR3c.pwr8fnfrnr8BX8UtFnYaqS','kim');

INSERT INTO kata_db.roles (role)
VALUES
('ROLE_ADMIN'),
('ROLE_USER');

INSERT INTO kata_db.users_roles (users_id,roles_id)
VALUES
(1,1),
(2,2),
(3,2);