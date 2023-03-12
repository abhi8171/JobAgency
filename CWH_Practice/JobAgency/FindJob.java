package CWH_Practice.JobAgency;
import java.sql.SQLClientInfoException;
import java.util.*;

class Job{
    String title;
    String [] skills;
    public  Job(String title,String skills[]){
        this.title= title;
        this.skills=skills;
    }
}
class JobSeekers{
    String name ;
    String [] ownskills;
    public JobSeekers(String name, String ownskills[]){
        this.name= name;
        this.ownskills=ownskills;
    }
}
class JobAgency{
    
    ArrayList<Job> jobs= new ArrayList<>();
    ArrayList<JobSeekers> jobSeekers= new ArrayList<>();
    public void addJob(String title,String skills[]){
       Job job = new Job(title, skills);
        this.jobs.add(job);
    }
    void addJobSeekers(String name,  String ownskills[]){
        JobSeekers jobSeekers = new JobSeekers(name,ownskills);
        this.jobSeekers.add(jobSeekers);
    }
    ArrayList<Job> matchedJob(String skill){
        ArrayList<Job> matchedJobs= new ArrayList<>();
        for(Job job :this.jobs){
            for(String s: job.skills){
                if(skill.equals(s)){
                    matchedJobs.add(job);
                }
            }
        }
        return matchedJobs;
    }
    ArrayList<JobSeekers> matchedJobSeekers(String skill){
        ArrayList<JobSeekers> matchedJobSeekers= new ArrayList<>();
        for(JobSeekers jobSeeker :this.jobSeekers){
            
            for(String s1 : jobSeeker.ownskills){
                if(s1.equals(skill))
                {
                    matchedJobSeekers.add(jobSeeker);
                }
            }
        }
        return matchedJobSeekers;
    }
}
public class FindJob{
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        JobAgency  jobAgency = new  JobAgency();
        String [] skillofjob1={"Java","Python","C++"};
        String [] skillofjob3={"HTML","CSS","JavaScript"};
        String [] skillofjob2={"SQL","Excel","Python"};
        jobAgency.addJob("Software Engineer",skillofjob1);
        jobAgency.addJob("Data Analyst",skillofjob2);
        jobAgency.addJob("Web  Developer",skillofjob3);

        String skillofAlice[] = {"SQL","Excel"};
        String skillofRakesh[] = {"HTML","C"};
        String skillofVibhu[] = {"C++","Java"};
        String skillofShivam[] = {"java","CSS"};
        String skillofParas[] = {"C++","Excel"};
        String skillofAkash[] = {"C","Python"};
        String skillofRoopam[] = {"SQL","Java"};
        String skillofSahil[] = {"HTML","c"};
        String skillofPiyush[] = {"JavaScript","Java"};
        String skillofPranshant[] = {"CSS","Excel"};
        String skillofRitesh[] = {"Python","Java"};

        jobAgency.addJobSeekers("Alice",skillofAlice);
        jobAgency.addJobSeekers("Rakesh",skillofRakesh);
        jobAgency.addJobSeekers("Vibhu",skillofVibhu);
        jobAgency.addJobSeekers("Shivam",skillofShivam);
        jobAgency.addJobSeekers("Paras",skillofParas);
        jobAgency.addJobSeekers("Akash",skillofAkash);
        jobAgency.addJobSeekers("Roopam",skillofRoopam);
        jobAgency.addJobSeekers("Sahil",skillofSahil);
        jobAgency.addJobSeekers("Piyush",skillofPiyush);
        jobAgency.addJobSeekers("Prashant",skillofPranshant);
        jobAgency.addJobSeekers("Ritesh",skillofRitesh);

        System.out.println("The Valid Skills are : HTML, Java, JavaScript, Python, C, C++ and Excel");
        System.out.print("Enter the Skill for which you want the job : ");
        String skills = ip.next();
        ArrayList<Job> matchedjobs = jobAgency.matchedJob(skills);
        ArrayList<JobSeekers>matchedjobseeker= jobAgency.matchedJobSeekers(skills);
        System.out.print("Matched Jobs is : ");
        for (Job matchjob : matchedjobs) {
            System.out.println(matchjob.title);
            System.out.print("Skills Required for "+matchjob.title+" : ");
            for(String s: matchjob.skills){
            
                System.out.print(s+" ");
            }
            
        }
        System.out.println(" ");
        //System.out.print("JobSeekers: ");
        for (JobSeekers jobSeekers : matchedjobseeker) {
            System.out.print("JobSeekers: ");
            System.out.println(jobSeekers.name);
            System.out.print("Skills  of "+ jobSeekers.name+ " : ");
            for (String s : jobSeekers.ownskills) {
                System.out.print(s+" ");
            }
            System.out.println(" ");
        }
        
    }
}