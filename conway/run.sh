#!/bin/bash

python3 -m mypy conway/game_of_life.py

rm -rf .mypy_cache

python3 conway/game_of_life.py