package org.launchcode.techjobs_oo.Tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;


public class JobTest {
    private static Job job1;
    private static Job job2;
    private static Job testJob1;
    private static Job testJob2;
    private static Job testJob3;
    private static Job testEmptyJob;

    @BeforeClass
    public static void createJobObjects() {
        job1 = new Job();
        job2 = new Job();
        testJob1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        testJob2 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        testJob3 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        testEmptyJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

    }


    //Test constructor is setting a unique ID for each job
    @Test
    public void testSettingJobId() {
        assertEquals(1, (job2.getId()) - (job1.getId()), .001);

        //assertEquals(1, job2.getId() - job1.getId(), .001);
        //assertFalse(job1.equals(job2));
        //assertTrue((job1.getId()) < (job2.getId()));
    }

    //Test constructor is assigning class and value of each field
    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product Tester", testJob1.getName());
        assertEquals("ACME", testJob1.getEmployer().getValue());
        assertEquals("Desert", testJob1.getLocation().getValue());
        assertEquals("Quality Control", testJob1.getPositionType().getValue());
        assertEquals("Persistence", testJob1.getCoreCompetency().getValue());

    }

    //Test jobs for equality
    @Test
    public void testJobsForEquality(){
        assertFalse(testJob1.equals(testJob2));
    }


    //Test if toString method starts and ends with blank line
    @Test
    public void testToStringFormat(){
        assertTrue(testJob1.toString().startsWith("\n")&& testJob1.toString().endsWith("\n"));
    }

    //Test if toString has label and data
    @Test
    public void testForJobFormat(){
        assertEquals((testJob1.toString()), ("\nID: 3\nName: Product Tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality Control\nCore Competency: Persistence\n"));
    }
    //Test toString if Job has empty data field
    @Test
    public void testJobEmptyData(){
        assertEquals((testJob3.toString()), ("Oops! This job does not seem to exist.") );
    }

    //Test for toString if job has ID
    @Test
    public void testJobIdOnly(){
        assertEquals(testEmptyJob.toString() , ("\nID: 5\nName: Product Tester\nEmployer: Data Not Available\nLocation: Data Not Available\nPosition Type: Quality Control\nCore Competency: Persistence\n"));
    }

}
