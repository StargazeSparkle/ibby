# ibby

ibby (lowercase) is an attempt at making a functional and useful MediaWiki client in Clojure. ibby mainly targets the Fandom installations but there is no reason that it could not be extended in order to work on any arbitrary installation. 

## Installation

Requirements:
* leiningen
* clojure
* jdk 8

Simply git-clone this repository and run `lein run` from inside of it.

## Notes
- Currently `clj-http` has some bug with how it calls the async API which raises bull-pointer exceptions in the JVM so for the time being this should not be used.

## Usage


    $ cd ibby
    $ lein run

## License

Copyright © 2020 Stargaze Sparkle

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program.  If not, see <https://www.gnu.org/licenses/>.
