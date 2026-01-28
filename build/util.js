'use strict';
const { execSync } = require('node:child_process')
const print = console.log;

const sh = command =>
    execSync(command, {encoding: 'utf8'});

const tryDef = (def, func, ...args) => {
    try {
        return func(...args);
    } catch (e) {
        return def;
    }
}

module.exports = Object.freeze({ tryDef, sh });
//module.exports = {tryDef: tryDef, sh: sh}; 
