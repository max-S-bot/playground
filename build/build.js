#!/usr/bin/env node

const fs = require('node:fs');
const util = require('./build/util.js')
const print = console.log;

const config = util.tryDef({}, require, './buildConfig.json');
const lib = tryDef([], fs.readFileSync, './lib');
const classes = util.classes();
const cp = '\"classes:lib/*\"';

doBuild();
util.sh(`java -cp ${cp} ${config.main}`); 

const doBuild = () => {
    util.sh(`mkdir -p classes`);
    compile('./');
}

const compile = dir => {
    for (const file of fs.readdirSync(dir)) {
        const extIdx = file.length - 5;
        if (file.slice(extIdx) === '.java')
            if (mod(file.slice(0, extIdx)))
                util.sh(`javac -d classes ${file}`);
    }
}

const manageLib = () => {
    for (const dep of config.lib)
        if (!lib.includes(dep))
            download(dep);
}

const mod = file =>
    !classes.includes(`${file}.class`) || 
    lastMod(`${file}.java`) > lastMod(`${file}.class`);

const lastMod = file => 
    parseInt(util.sh(`stat -c %Y ${file}`));

/*
    json structure: 
    {
        "lib": [{version, name, etc}],
        "main": "foo"
        // more stuff? 
    } 
*/