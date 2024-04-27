const PassengerPlane = require('./Planes/PassengerPlane');
const MilitaryPlane = require('./Planes/MilitaryPlane');
const MilitaryType = require('./models/MilitaryType');
const ExperimentalPlane = require('./Planes/ExperimentalPlane');

class Airport {
  constructor(planes) {
    this._planes = planes;
  }

  get planes() {
    return this._planes;
  }

  getPassengerPlanes() {
    return this._planes.filter(plane => plane instanceof PassengerPlane);
  }

  getMilitaryPlanes() {
    return this._planes.filter(plane => plane instanceof MilitaryPlane);
  }

  getExperimentalPlanes() {
    return this._planes.filter(plane => plane instanceof ExperimentalPlane);
  }

  sortByMaxDistance() {
    this._planes.sort((a, b) => a.maxFlightDistance - b.maxFlightDistance);
    return this;
  }

  sortByMaxSpeed() {
    this._planes.sort((a, b) => a.maxSpeed - b.maxSpeed);
    return this;
  }

  sortByMaxLoadCapacity() {
    this._planes.sort((a, b) => a.maxLoadCapacity - b.maxLoadCapacity);
    return this;
  }

  getPassengerPlaneWithMaxPassengersCapacity() {
    const passengerPlanes = this.getPassengerPlanes();
    return passengerPlanes.reduce((maxCapacityPlane, plane) => {
      return plane.passengersCapacity > maxCapacityPlane.passengersCapacity ? plane : maxCapacityPlane;
    }, passengerPlanes[0]);
  }
}

module.exports = Airport;




