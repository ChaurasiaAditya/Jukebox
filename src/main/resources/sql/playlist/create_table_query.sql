-- Create playlist Table in the jukebox database
    CREATE TABLE IF NOT EXISTS `playlists`
    (
        `id` int not null primary key AUTO_INCREMENT,
        `name` varchar(50) not null,
        `songs_list` varchar(50) not null
    );