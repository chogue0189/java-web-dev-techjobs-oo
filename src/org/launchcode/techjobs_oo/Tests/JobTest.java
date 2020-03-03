package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JobTest {
    private static Job job1;
    private static Job job2;
    private static Job testJob1;
    private static Job testJob2;
    private static Job testJob3;


    //Test constructor is setting a unique ID for each job
    @Test
    public void testSettingJobId() {
        job1 = new Job ();
        job2 = new Job ();
        testJob1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        testJob2 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        testJob3 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(1, job2.getId() - job1.getId(), .001);
        //assertFalse(job1.equals(job2));
        //assertTrue((job1.getId()) < (job2.getId()));
    }

    //Test constructor is assigning class and value of each field
    @Test
    public void testJobConstructorSetsAllFields() {
        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(testJob1.getEmployer(), testJob1.getValue(), testJob1.getLocation(), testJob1.getValue());

    }
    //Test jobs for equality
    @Test
    public void testJobsForEquality(){
        assertFalse(testJob1.equals(testJob2));
    }
}
