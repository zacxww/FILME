-- Adiciona as novas colunas à tabela FILME se não existirem
ALTER TABLE FILME ADD COLUMN IF NOT EXISTS DIRETOR VARCHAR(255);
ALTER TABLE FILME ADD COLUMN IF NOT EXISTS ANO INTEGER;
ALTER TABLE FILME ADD COLUMN IF NOT EXISTS SINOPSE VARCHAR(2000);
ALTER TABLE FILME ADD COLUMN IF NOT EXISTS POSTER_URL VARCHAR(500);

-- Insere dados de exemplo
INSERT INTO FILME (NOME, DESCRICAO, data_lancamento, DIRETOR, ANO, SINOPSE, GENEROS, POSTER_URL) 
VALUES ('Interestelar', 'Filme de ficção científica', '2014-11-07', 'Christopher Nolan', 2014, 
'Em um futuro próximo, a Terra está cada vez mais inabitável. Um grupo de astronautas é enviado para explorar um buraco de minhoca recém-descoberto em busca de um planeta habitável para a humanidade.', 
'FICCAO_CIENTIFICA,DRAMA,AVENTURA',
'https://image.tmdb.org/t/p/w500/nrSaXF39nDfAAeLKksRCyvSzI2a.jpg')
ON CONFLICT (ID) DO NOTHING;

INSERT INTO FILME (NOME, DESCRICAO, data_lancamento, DIRETOR, ANO, SINOPSE, GENEROS, POSTER_URL) 
VALUES ('Parasita', 'Filme sul-coreano premiado', '2019-05-30', 'Bong Joon-ho', 2019, 
'Uma família pobre engana uma família rica para conseguir empregos em sua mansão, mas um incidente inesperado ameaça expor seu esquema.', 
'DRAMA,COMEDIA,SUSPENSE',
'https://image.tmdb.org/t/p/w500/igw938inb6Fy0YVcwIyxQ7Lu5FO.jpg')
ON CONFLICT (ID) DO NOTHING;

INSERT INTO FILME (NOME, DESCRICAO, data_lancamento, DIRETOR, ANO, SINOPSE, GENEROS, POSTER_URL) 
VALUES ('Pulp Fiction', 'Filme de Tarantino', '1994-10-14', 'Quentin Tarantino', 1994, 
'As vidas de dois assassinos da máfia, um boxeador, um gângster e sua esposa, e um par de bandidos se entrelaçam em quatro histórias de violência e redenção.', 
'CRIME,DRAMA,COMEDIA',
'https://image.tmdb.org/t/p/w500/d5iIlFn5s0ImszYzBPb8JPIfbXD.jpg')
ON CONFLICT (ID) DO NOTHING;

