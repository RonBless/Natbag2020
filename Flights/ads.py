#!/usr/bin/python
import subprocess

from flask import Flask, request

app = Flask("natbag2020_app")


def flight(direction,direction2):
    return subprocess.check_output(["java", "-classpath",   #Linux command
                                    "bin", "main.Main",
                                    request.args.get('outformat'), direction, #check if departures is args[1]
                                    request.args.get('airline'), request.args.get(direction2), #args[2], args[3]
                                    request.args.get('flightNumber'), #enter "-1" in order to ignore it in search
                                    request.args.get('year1'), request.args.get('month1'),#args[5], args[6]
                                    request.args.get('day1'), request.args.get('year2'),
                                    request.args.get('month2'), request.args.get('day2'),
                                    request.args.get('sunday'), request.args.get('monday'),
                                    request.args.get('tuesday'), request.args.get('wednesday'),
                                    request.args.get('thursday'), request.args.get('friday'),
                                    request.args.get('saturday')])


@app.route("/departures")
def dep():
    return flight("departures", "country")


@app.route("/landings")
def arr():
    return flight("landings", "origin")


app.run(port=8000, host="0.0.0.0")

#depatrue flight link
#http://localhost:8000/departures?outformat=html&country=Amsterdam&airline=elal&flightNumber=002&day1=4&month1=6&year1=2020&day2=31&month2=7&year2=2021&sunday=true&monday=false&tuesday=true&wednesday=true&thursday=false&friday=false&saturday=false

#landing flight link
#http://localhost:8000/landings?outformat=html&origin=TELAVIV&airline=AmericaAirLines&flightNumber=003&day1=4&month1=6&year1=2020&day2=31&month2=7&year2=2022&sunday=true&monday=true&tuesday=true&wednesday=true&thursday=true&friday=true&saturday=true