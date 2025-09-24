<?php

var_dump(
    'single quotes',
    "double quotes",

    'escaped single quote \' in single quotes',
    'escaped double quote \" in single quotes',

    "escaped single quote \' in double quotes",
    "escaped double quote \" in double quotes",

    'quoted "string" in single quoted string',

    'concatenated' . 'string',
    'concatenated' . "string2",
    'concatenated with const' . PHP_EOL . 'string',

    sprintf('templated string'),
    sprintf('templated string with %s', 'variable'),
    sprintf('templated string with "%s" in quotes', 'variable'),

    base64_encode("base64 encoded string"),

    str_repeat('repeated string', 3),
    str_replace('repeated', 'replaced', 'repeated string'),
    substr('repeated string', 9),
    substr('repeated string', 0, -6),

    ord('A'),
    mb_ord('A'),

    chr(34),
    mb_chr(34),

    explode(' ', 'explode me'),
    implode(' ', ['implode', 'me']),

    str_split('split string'),
    mb_str_split('split string'),

    str_starts_with('php', 'p'),

    str_pad('pad', 10, '-'),
    str_shuffle('shuffled string'),
    strcmp('str1', 'str2'),

);