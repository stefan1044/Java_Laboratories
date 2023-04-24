CREATE TABLE albums.albums
(
    id serial NOT NULL,
    release_year date NOT NULL,
    title text NOT NULL,
    artist text NOT NULL,
    genre text,
    PRIMARY KEY (title, artist)
);

ALTER TABLE IF EXISTS albums.albums
    OWNER to postgres;

CREATE TABLE albums.artists
(
    id serial NOT NULL,
    name name NOT NULL,
    PRIMARY KEY (name)
);

ALTER TABLE IF EXISTS albums.artists
    OWNER to postgres;

CREATE TABLE albums.genres
(
    id serial NOT NULL,
    name text NOT NULL,
    PRIMARY KEY (name)
);

ALTER TABLE IF EXISTS albums.genres
    OWNER to postgres;

CREATE TABLE albums.junction
(
    artist text NOT NULL,
    genre text NOT NULL,
    PRIMARY KEY (artist, genre),
    CONSTRAINT artist FOREIGN KEY (artist)
        REFERENCES public.artists (name) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT genre FOREIGN KEY (genre)
        REFERENCES public.genres (name) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);

ALTER TABLE IF EXISTS albums.junction
    OWNER to postgres;
