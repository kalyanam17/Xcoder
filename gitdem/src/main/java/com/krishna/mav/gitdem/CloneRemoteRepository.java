package com.krishna.mav.gitdem;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class CloneRemoteRepository {

	public static void main(String[] args) throws IOException, GitAPIException {
		String REMOTE_URL = "https://github.com/ruby/ruby.git";
		File path = File.createTempFile("RetriveRepository", "");
        if(!path.delete()){
            throw new IOException("Could not delete Folder");
        }
        
        System.out.println("Cloning from " + REMOTE_URL + " to " + path);
        try (Git result = Git.cloneRepository()
                    .setURI(REMOTE_URL)
                    .setDirectory(path)
                    .call()){
            System.out.println("Repository at: " + result.getRepository().getDirectory());
		
	}

	}}
