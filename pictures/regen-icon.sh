#!/bin/sh
#
# This file is a part of Null Launcher.
# Copyright 2013 Michael Howell <michael@notriddle.com>
#
# Null Launcher is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# Null Launcher is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with Null Launcher. If not, see <http://www.gnu.org/licenses/>.

inkscape -e ../res/drawable-mdpi/ic_launcher.png -w 48 -h 48 -z ic_launcher.svg
inkscape -e ../res/drawable-hdpi/ic_launcher.png -w 72 -h 72 -z ic_launcher.svg
inkscape -e ../res/drawable-xhdpi/ic_launcher.png -w 96 -h 96 -z ic_launcher.svg
inkscape -e large_launcher.png -w 512 -h 512 -z ic_launcher.svg

