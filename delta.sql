--insert user
INSERT INTO public.users (id, birth_date, email, first_name, initial_score, last_name, password, preferences, short_name, token, work) VALUES ('2689b85c-9d7f-4311-b0f9-ecd8de0bc321', '1995-10-09 21:00:00.000000', 'vitor', 'vitor', 10.00, 'marques', '$2a$10$vYMfFOqdJi45ryfEAVgtz.eqXzC/b7D31vY48WyI2F3gOoh23LPIy', null, 'vitor', '52bcc69b-602f-467a-95de-594cdd1d88bb', true);

--insert module
INSERT INTO public.module (id, descrition, image, name, module_order) VALUES ('3a63f50a-a8d9-4424-8b6b-1ba12a529dab', 'Module 1', 'https://static01.nyt.com/images/2018/08/26/business/26VIEW.illo/26VIEW.illo-articleLarge.jpg?quality=75&auto=webp&disable=upscale', 'Module 1', 1);
INSERT INTO public.module (id, descrition, image, name, module_order) VALUES ('7ea0a88b-9d62-4fe6-b991-4e147d25182c', 'Module 2', 'https://ogimg.infoglobo.com.br/economia/23226773-ffd-520/FT1086A/652/Porquinho_poupanca.jpg', 'Module 2', 2);

--insert submodule
INSERT INTO public.submodule (id, content, image, name, quiz_id, module_id, submodule_order) VALUES ('199a4c83-f21d-4634-9645-923c0317090d', 'Submodule 1.1', 'https://static.independent.co.uk/s3fs-public/thumbnails/image/2019/04/15/11/money.jpg', 'Submodule 1.1', null, '3a63f50a-a8d9-4424-8b6b-1ba12a529dab', 1);
INSERT INTO public.submodule (id, content, image, name, quiz_id, module_id, submodule_order) VALUES ('621c5aa3-bfc6-4df8-897b-148d53701cac', 'Submodule 1.2', 'https://media3.s-nbcnews.com/j/newscms/2019_06/2746941/190208-stock-money-fanned-out-ew-317p_fa445b2f6f3e86a3ffa18707e6a8adcb.fit-760w.jpg', 'Submodule 1.2', null, '3a63f50a-a8d9-4424-8b6b-1ba12a529dab', 2);
INSERT INTO public.submodule (id, content, image, name, quiz_id, module_id, submodule_order) VALUES ('d5b5587b-b01a-4f8d-b425-d6339ed3783b', 'Submodule 2.1', 'https://nossamelhoridade.com.br/wp-content/uploads/2018/11/porquinho-da-poupan%C3%A7a.jpeg', 'Submodule 2.1', null, '7ea0a88b-9d62-4fe6-b991-4e147d25182c', 1);
INSERT INTO public.submodule (id, content, image, name, quiz_id, module_id, submodule_order) VALUES ('37c77b67-91f1-48ef-8e1a-1c2d79d9302b', 'Submodule 2.2', 'http://s2.glbimg.com/UUrqaYCBBeHmv7z10Aq0mDrlNFE=/940x523/e.glbimg.com/og/ed/f/original/2016/07/15/dinheiro-poupanca.jpg', 'Submodule 2.2', null, '7ea0a88b-9d62-4fe6-b991-4e147d25182c', 2);
INSERT INTO public.submodule (id, content, image, name, quiz_id, module_id, submodule_order) VALUES ('cdf38c5d-9407-4c6e-9780-3f3f45a45ff6', 'Submodule 2.3', 'http://www.profissaoatitude.com.br/files//Uploads/UploadBass/8872812_PORQUINHO.jpg', 'Submodule 2.3', null, '7ea0a88b-9d62-4fe6-b991-4e147d25182c', 3);

--insert user progress
INSERT INTO public.user_module_progress (id, moduleid, module_type, status_type, user_id) VALUES ('991ba6ee-9262-4983-9bdf-eed7abf8444b', '3a63f50a-a8d9-4424-8b6b-1ba12a529dab', 0, 0, '2689b85c-9d7f-4311-b0f9-ecd8de0bc321');
INSERT INTO public.user_module_progress (id, moduleid, module_type, status_type, user_id) VALUES ('db953441-0f2c-4174-8349-8dbe96a4d005', '199a4c83-f21d-4634-9645-923c0317090d', 1, 0, '2689b85c-9d7f-4311-b0f9-ecd8de0bc321');
INSERT INTO public.user_module_progress (id, moduleid, module_type, status_type, user_id) VALUES ('9edc3fce-c69a-4f4a-9b6d-9f9da2dabe61', '7ea0a88b-9d62-4fe6-b991-4e147d25182c', 0, 0, '2689b85c-9d7f-4311-b0f9-ecd8de0bc321');
INSERT INTO public.user_module_progress (id, moduleid, module_type, status_type, user_id) VALUES ('d8e5511d-7afe-4347-aa16-508bec032bfb', 'd5b5587b-b01a-4f8d-b425-d6339ed3783b', 1, 0, '2689b85c-9d7f-4311-b0f9-ecd8de0bc321');
INSERT INTO public.user_module_progress (id, moduleid, module_type, status_type, user_id) VALUES ('0e9f7ff0-fb11-41d3-9b3c-d1f2ca76dbec', '37c77b67-91f1-48ef-8e1a-1c2d79d9302b', 1, 0, '2689b85c-9d7f-4311-b0f9-ecd8de0bc321');