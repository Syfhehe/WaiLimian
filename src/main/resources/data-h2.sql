MERGE INTO user (user_name, password, active, role) 
   KEY(user_name)
VALUES
  ('aaa@test.com', 'dcc4072993a386d936506857c54060dc', true, 'ADMIN'),
  ('bbb@test.com', '1c9f57b789f04333424a599e087ed889', true, 'USER');