package org.launchcode.techjobs.oo.test;

import jdk.nashorn.api.tree.TemplateLiteralTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job a = new Job();
        Job b = new Job();

        assertNotEquals(a.getId(), b.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertEquals(job.getName(), "Product tester");
        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertTrue(job.getLocation() instanceof Location);
        assertEquals(job.getLocation().getValue(), "Desert");
        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job();

        assertEquals(job.toString().charAt(0), '\n');
        assertEquals(job.toString().charAt(job.toString().length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String []generatedData = job.toString().trim().split("\\n");
        String []expectedData = {
                "Name: Product tester",
                "Employer: ACME",
                "Location: Desert",
                "Position Type: Quality control",
                "Core Competency: Persistence"
        };

        for(int i = 1; i < generatedData.length; i++) {
            assertEquals(expectedData[i - 1], generatedData[i]);
        }
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job []jobs = {
            new Job(null, new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence")),
                new Job("Product tester", null, new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence")),
                new Job("Product tester", new Employer("ACME"), null, new PositionType("Quality control"), new CoreCompetency("Persistence")),
                new Job("Product tester", new Employer("ACME"), new Location("Desert"), null, new CoreCompetency("Persistence")),
                new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), null),
        };

        class EmptyFieldJobTestStructure {
            int indexToTest;
            String valueToTest;
            Job job;

            public EmptyFieldJobTestStructure(int indexToTest, String valueToTest, Job job) {
                this.indexToTest = indexToTest;
                this.valueToTest = valueToTest;
                this.job = job;
            }

            int getIndexToTest() {
                return indexToTest;
            }

            String getValueToTestAgainst() {
                return valueToTest + ": Data not available";
            }

            String getValueFromJob() {
                return job.toString().trim().split("\\n")[indexToTest];
            }

            public void executeTest() {
                assertEquals(getValueFromJob(), getValueToTestAgainst());
            }
        }


        EmptyFieldJobTestStructure []dataToTest = {
                new EmptyFieldJobTestStructure(1, "Name", jobs[0]),
                new EmptyFieldJobTestStructure(2, "Employer", jobs[1]),
                new EmptyFieldJobTestStructure(3,"Location", jobs[2]),
                new EmptyFieldJobTestStructure(4,"Position Type", jobs[3]),
                new EmptyFieldJobTestStructure(5,"Core Competency", jobs[4])
        };

        for(EmptyFieldJobTestStructure test: dataToTest) {
            test.executeTest();
        }
    }
}

