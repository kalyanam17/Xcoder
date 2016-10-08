package com.krishna.mav.gitdem;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand.ListMode;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.treewalk.TreeWalk;

public class BranchesWithoutravis {

	static String REMOTE_URL = "https://github.com/ruby/ruby.git";

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, GitAPIException {

		FileRepositoryBuilder builder = new FileRepositoryBuilder();

		Repository repository = builder
				.setGitDir(new File("C:/Users/Krishna/AppData/Local/Temp/RetriveRepository3880270823967579677/.git"))
				.readEnvironment().findGitDir().build();
		Set<String> gitty = new TreeSet<>();
		try (Git git = new Git(repository)) {
			List<Ref> call = git.branchList().call();
			call = git.branchList().setListMode(ListMode.ALL).call();

			for (Ref ref : call) {
				gitty.add(ref.getName());
				RevWalk walk = new RevWalk(repository);

				RevCommit commit = walk.parseCommit(ref.getObjectId());
				RevTree tree = commit.getTree();

				TreeWalk treeWalk = new TreeWalk(repository);
				treeWalk.addTree(tree);
				treeWalk.setRecursive(true);
				Boolean cool = false;
				while (treeWalk.next()) {
					cool = treeWalk.getPathString().contentEquals(".travis.yml");

					if (cool == true) {
						gitty.remove(ref.getName());
					}
				}

			}
		}

		Iterator<String> Itr = gitty.iterator();
		while (Itr.hasNext()) {
			System.out.println(Itr.next());

		}
		repository.close();

	}

}