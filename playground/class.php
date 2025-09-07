<?php

namespace App\HTTP;

class Controller
{
    private const PRIVATE_CONST = [];

    function getAction()
    {
        \time();
        return render(self::PRIVATE_CONST);
    }
}

function render(mixed $values): mixed
{

}