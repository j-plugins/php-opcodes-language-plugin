<?php

function match1()
{
    match (true) {
        123 => 2,
        'text' => 1,
        default => 0,
    };
}


function match2()
{
    /**
     * @var $arg
     */
    $variable = null;

    $res = match ($arg ?: false ?? null) {
        my_func($variable, true) => 4,
        null => 4,
        $variable => 3,
        123 => 2,
        'text' => 1,
        default => 0,
    };
}