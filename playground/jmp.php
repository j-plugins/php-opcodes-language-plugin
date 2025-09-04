<?php

function if_regular()
{
    if (true) {
        return 1;
    }
}

function if_else_regular()
{
    if (true) {
        return 1;
    } else {
        return 2;
    }
}

function if_elseif_regular()
{
    if (true) {
        return 1;
    } elseif (false) {
        return 2;
    }
}

function if_elseif_else_regular()
{
    if (true) {
        return 1;
    } elseif (false) {
        return 2;
    } else {
        return 3;
    }
}