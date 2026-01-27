const fs = require('node:fs');
const { execSync } = require('node:child_process')
const print = console.log;

const sh = command =>
    execSync(command, {encoding: 'utf8'});

const classes = () =>
    tryDef([], fs.readdirSync, './classes');

const tryDef = (def, func, ...args) => {
    try {
        return func(...args);
    } catch (e) {
        return def;
    }
}

module.exports = {classes, tryDef, sh};
