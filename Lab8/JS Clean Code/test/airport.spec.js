const assert = require('chai').assert;
const Plane = require('../Planes/Plane');
const MilitaryPlane = require('../Planes/MilitaryPlane');
const PassengerPlane = require('../Planes/PassengerPlane');
const Airport = require('../Airport');
const MilitaryType = require('../models/MilitaryType');
const experimentalPlane = require('../Planes/ExperimentalPlane');
const ExperimentalTypes = require('../models/ExperimentalTypes');
const ClassificationLevel = require('../models/ClassificationLevel');

describe('Airport Tests', () => {
    let planes;
    let planeWithMaxPassengerCapacity;

    beforeEach(() => {
        planes = [
            new PassengerPlane('Boeing-737', 900, 12000, 60500, 164),
            // ... остальные самолеты
        ];
        planeWithMaxPassengerCapacity = new PassengerPlane(
            'Boeing-747',
            980,
            16100,
            70500,
            242
        );
    });

    it('should have military planes with transport type', () => {
        // Arrange
        const airport = new Airport(planes);

        // Act
        const transportMilitaryPlanes = airport.getTransportMilitaryPlanes();

        // Assert
        const hasTransportMilitaryPlanes = transportMilitaryPlanes.some(
            (militaryPlane) =>
                militaryPlane.getMilitaryType() === MilitaryType.TYPE_TRANSPORT
        );
        assert.isTrue(hasTransportMilitaryPlanes);
    });

    it('should find passenger plane with max capacity', () => {
        // Arrange
        const airport = new Airport(planes);

        // Act
        const expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();

        // Assert
        assert.notStrictEqual(
            expectedPlaneWithMaxPassengersCapacity,
            planeWithMaxPassengerCapacity
        );
    });

    it('should sort planes by max load capacity', () => {
        // Arrange
        console.log('TEST sortByMaxLoadCapacity started!');
        const airport = new Airport(planes);

        // Act
        airport.sortByMaxLoadCapacity();
        const planesSortedByMaxLoadCapacity = airport.getPlanes();

        // Assert
        let nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (let i = 0; i < planesSortedByMaxLoadCapacity.length - 1; i++) {
            const currentPlane = planesSortedByMaxLoadCapacity[i];
            const nextPlane = planesSortedByMaxLoadCapacity[i + 1];
            if (currentPlane.getMinLoadCapacity() > nextPlane.getMinLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }

        assert.isTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    });

    it('should have at least one bomber in military planes', () => {
        // Arrange
        const airport = new Airport(planes);

        // Act
        const bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();

        // Assert
        const hasBomberMilitaryPlanes = bomberMilitaryPlanes.some(
            (militaryPlane) =>
                militaryPlane.getMilitaryType() === MilitaryType.BOMBER
        );
        assert.isTrue(hasBomberMilitaryPlanes);
    });

    it('should check that experimental planes have classification level higher than unclassified', () => {
        // Arrange
        const airport = new Airport(planes);

        // Act
        const experimentalPlanes = airport.getExperimentalPlanes();

        // Assert
        const hasUnclassifiedPlanes = experimentalPlanes.some(
            (experimentalPlane) =>
                experimentalPlane.classificationLevel === ClassificationLevel.UNCLASSIFIED
        );
        assert.isFalse(hasUnclassifiedPlanes);
    });
});

