// Print the stats of the horse the player is looking at

command() -> (
    target = query(player(), 'trace', 4.5, 'entities');
    if (has({'horse', 'donkey', 'mule'}, target~'type'),
        stats = map(['minecraft:max_health', 'minecraft:movement_speed', 'minecraft:jump_strength'],
            getattribute(target, ));
        print(format(
            ' Health: ', 'd ' + str('%d', stats:0),
            ' \ Speed: ', 'd ' + str('%.6f', stats:1),
            ' \ Jump: ', 'd ' + str('%.5f', stats:2)
        ))
    );
    null
);

__get_attribute(target, attribute) -> (
    number(
        run('attribute ' + target~'uuid' + ' ' + attribute + ' base get')
        :1:0~'[.0-9]*$'
    )
) 
