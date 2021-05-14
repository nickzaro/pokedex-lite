
/*Tipos de pokémon */
INSERT INTO `types` (id,name,description) VALUES (0,'Planta','Es del tipo planta');
INSERT INTO `types` (id,name,description) VALUES (1,'Veneno','Es del tipo Veneno');
INSERT INTO `types` (id,name,description) VALUES (2,'Fuego','Es del tipo Fuego');
INSERT INTO `types` (id,name,description) VALUES (3,'Volador','Es del tipo Volador');
INSERT INTO `types` (id,name,description) VALUES (4,'Agua','Es del tipo Agua');
INSERT INTO `types` (id,name,description) VALUES (5,'Bicho','Es del tipo Bicho');
INSERT INTO `types` (id,name,description) VALUES (6,'Normal','Es del tipo Normal');
INSERT INTO `types` (id,name,description) VALUES (7,'Eléctrico','Es del tipo Eléctrico');
INSERT INTO `types` (id,name,description) VALUES (8,'Tierra','Es del tipo Tierra');
INSERT INTO `types` (id,name,description) VALUES (9,'Hada','Es del tipo Hada');
INSERT INTO `types` (id,name,description) VALUES (10,'Lucha','Es del tipo Lucha');
INSERT INTO `types` (id,name,description) VALUES (11,'Psíquico','Es del tipo Psíquico');
INSERT INTO `types` (id,name,description) VALUES (12,'Roca','Es del tipo Roca');
INSERT INTO `types` (id,name,description) VALUES (13,'Acero','Es del tipo Acero');
INSERT INTO `types` (id,name,description) VALUES (14,'Fantasma','Es del tipo Fantasma');

/* Abilities */
INSERT INTO `abilities` (id,name,description) VALUES (0,'Recogida','Puede recoger objetos que el rival haya usado, o bien otros que encuentre en plena aventura.');
INSERT INTO `abilities` (id,name,description) VALUES (1,'Experto','Potencia sus movimientos más débiles.');
INSERT INTO `abilities` (id,name,description) VALUES (2,'Flexibilidad','Evita ser paralizado gracias a la flexibilidad de su cuerpo.');
INSERT INTO `abilities` (id,name,description) VALUES (3,'Humedad','Aumenta la humedad del entorno y evita que se puedan utilizar movimientos explosivos, tales como Autodestrucción.');
INSERT INTO `abilities` (id,name,description) VALUES (4,'Aclimatación','Anula todos los efectos del tiempo atmosférico.');
INSERT INTO `abilities` (id,name,description) VALUES (5,'Absorbe Agua','Si le alcanza un movimiento de tipo Agua, recupera PS en vez de sufrir daño.');
INSERT INTO `abilities` (id,name,description) VALUES (6,'Foco Interno','Gracias a su profunda concentración, no se amedrenta ante los ataques del rival.');
INSERT INTO `abilities` (id,name,description) VALUES (7,'Sincronía','Contagia el envenenamiento, las quemaduras o la parálisis al Pokémon que le cause ese estado.');
INSERT INTO `abilities` (id,name,description) VALUES (8,'Espesura','Potencia sus movimientos de tipo Planta cuando le quedan pocos PS.');
INSERT INTO `abilities` (id,name,description) VALUES (9,'Mar Llamas','Potencia sus movimientos de tipo Fuego cuando le quedan pocos PS.');
INSERT INTO `abilities` (id,name,description) VALUES (10,'Torrente','Potencia sus movimientos de tipo Agua cuando le quedan pocos PS.');
INSERT INTO `abilities` (id,name,description) VALUES (11,'Polvo Escudo','El polvo de escamas que lo envuelve lo protege de los efectos secundarios de los ataques recibidos.');
INSERT INTO `abilities` (id,name,description) VALUES (12,'Mudar','Puede curar sus problemas de estado al mudar la piel.');
INSERT INTO `abilities` (id,name,description) VALUES (13,'Ojo Compuesto','Aumenta la precisión de sus movimientos.');
INSERT INTO `abilities` (id,name,description) VALUES (14,'Enjambre','Potencia sus movimientos de tipo Bicho cuando le quedan pocos PS.');
INSERT INTO `abilities` (id,name,description) VALUES (15,'Vista Lince','Su aguda vista evita que le disminuya la Precisión.');
INSERT INTO `abilities` (id,name,description) VALUES (16,'Tumbos','Sube su Evasión si está confuso.');
INSERT INTO `abilities` (id,name,description) VALUES (17,'Fuga','Puede escaparse de todos los Pokémon salvajes.');
INSERT INTO `abilities` (id,name,description) VALUES (18,'Agallas','Si sufre un problema de estado, se viene arriba y aumenta su Ataque.');

/* Pokémons */

INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (2,'Venusaur',100,'La planta florece cuando absorbe energía solar, lo cual le obliga a buscar siempre la luz del sol.',null);
INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (1,'Ivasaur',10,'Cuando le crece bastante el bulbo del lomo, pierde la capacidad de erguirse sobre las patas traseras.',2);
INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (0,'Bulbasaur',1,'Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo.',1);


INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (5,'Charizard',200,'Escupe un fuego tan caliente que funde las rocas. Causa incendios forestales sin querer.',null);
INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (4,'Charmeleon',20,'Este Pokémon de naturaleza agresiva ataca en combate con su cola llameante y hace trizas al rival con sus afiladas garras.',5);
INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (3,'Charmander',2,'Prefiere las cosas calientes. Dicen que cuando llueve le sale vapor de la punta de la cola.',4);

INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (8,'Blastoise',300,'Para acabar con su enemigo, lo aplasta con el peso de su cuerpo. En momentos de apuro, se esconde en el caparazón.',null);
INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (7,'Wartortle',30,'Se lo considera un símbolo de longevidad. Los ejemplares más ancianos tienen musgo sobre el caparazón.',8);
INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (6,'Squirtle',3,'Cuando retrae su largo cuello en el caparazón, dispara agua a una presión increíble.',7);

INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (11,'Pidgeot',400,'Este Pokémon vuela a una velocidad de 2 mach en busca de presas. Sus grandes garras son armas muy peligrosas.',null);
INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (10,'Pidgeotto',40,'Su extraordinaria vitalidad y resistencia le permiten cubrir grandes distancias del territorio que habita en busca de presas.',11);
INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (9,'Pidgey',4,'Su docilidad es tal que suelen defenderse levantando arena en lugar de contraatacar.',10);

INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (13,'Raticate',50,'Gracias a las pequeñas membranas de las patas traseras, puede nadar por los ríos para capturar presas.',null);
INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (12,'Rattata',5,'Es propenso a hincar los incisivos en cualquier cosa que se le ponga por delante. Si se ve alguno, seguramente haya cuarenta cerca.',13);

INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (15,'Persian',60,'Trabar amistad con este Pokémon es una ardua tarea debido a su enorme orgullo. Cuando algo no le place, saca las uñas de inmediato.',null);
INSERT INTO `pokemons` (pokemon_id,name,level,description,evolution_id) VALUES (14,'Meowth',6,'Le encanta reunir objetos brillantes. Cuando está de buen humor, hasta le muestra la colección a su Entrenador.',15);

/* Bulbasaur */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (0,0);
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (0,1);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (0,8);
/* Ivysaur */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (1,0);
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (1,1);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (1,8);
/* Venusaur */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (2,0);
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (2,1);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (2,8);

/* Charmander */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (3,2);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (3,9);
/* Charmeleon */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (4,2);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (4,9);
/* Charizard */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (5,2);
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (5,3);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (5,9);

/* Squirtle */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (6,4);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (6,10);
/* Wartortle */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (7,4);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (7,10);
/* Blastoise */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (8,4);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (8,10);

/* Pidgey */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (9,3);
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (9,6);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (9,15);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (9,16);
/* Pidgeotto */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (10,3);
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (10,6);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (10,15);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (10,16);
/* Pidgeot */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (11,3);
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (11,6);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (11,15);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (11,16);

/* Rattata */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (12,6);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (12,17);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (12,18);
/* Raticate */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (13,6);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (13,17);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (13,18);

/* Meowth */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (14,6);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (14,0);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (14,1);
/* Persian */
INSERT INTO `pokemon_type` (pokemon_id,type_id) VALUES (15,6);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (15,1);
INSERT INTO `pokemon_ability` (pokemon_id,ability_id) VALUES (15,2);

/* Usuarios del pokedex */
INSERT INTO `users` (id,name) VALUES (0,'John');
INSERT INTO `users` (id,name) VALUES (1,'Linus');
INSERT INTO `users` (id,name) VALUES (2,'Jane');
INSERT INTO `users` (id,name) VALUES (3,'Bruce');

/* user_pokemon */
/*John*/
INSERT INTO `user_pokemon` (alias,current_level,user_pokemon_id,user_id) VALUES ('JBulbasaur',2,0,0);
INSERT INTO `user_pokemon` (alias,current_level,user_pokemon_id,user_id) VALUES ('JIvysaur',22,1,0);
INSERT INTO `user_pokemon` (alias,current_level,user_pokemon_id,user_id) VALUES ('JVenusaur',220,2,0);

/*Linus*/
INSERT INTO `user_pokemon` (alias,current_level,user_pokemon_id,user_id) VALUES ('LCharmander',3,3,1);
INSERT INTO `user_pokemon` (alias,current_level,user_pokemon_id,user_id) VALUES ('LCharmeleon',30,4,1);
INSERT INTO `user_pokemon` (alias,current_level,user_pokemon_id,user_id) VALUES ('LCharizard',330,5,1);
