package com.krishna.mav.gitdem;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand.ListMode;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class ListBranches {

	public static void main(String[] args) throws IOException, GitAPIException {
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		Repository repository = builder
				.setGitDir(new File("C:/Users/Krishna/AppData/Local/Temp/RetriveRepository3880270823967579677/.git"))
				.readEnvironment().findGitDir().build();
		try (Git git = new Git(repository)) {
			List<Ref> call = git.branchList().call();

			System.out.println("Now including remote branches:");
			call = git.branchList().setListMode(ListMode.ALL).call();
			for (Ref ref : call) {
				System.out.println("Branch: " + ref + " " + ref.getName() + " " + ref.getObjectId().getName());
			}
		}
	}
}
