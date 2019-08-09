package day26.school;

public class SubjectList {
	private static Subject[] subjectList = { new Subject("Maths 1", "A-MATMTC-101", SubjectType.MATH),
			new Subject("Maths 2", "S-MATMTC-201", SubjectType.MATH),
			new Subject("Korean Basic Lvl", "B-KOREAN-102", SubjectType.KOREAN),
			new Subject("Korean Advanced Lvl", "T-KOREAN-202", SubjectType.KOREAN),
			new Subject("English Basic Lvl", "B-ENGLSH-103", SubjectType.ENGLISH),
			new Subject("English Advanced Lvl", "T-ENGLSH-203", SubjectType.ENGLISH),
			new Subject("Chemistry 1", "A-CHEMST-104", SubjectType.CHEMISTRY),
			new Subject("Chemistry 2", "U-CHEMST-204", SubjectType.CHEMISTRY),
			new Subject("Physics 1", "A-PHYSCS-105", SubjectType.PHYSICS),
			new Subject("Physics 2", "U-PHYSCS-205", SubjectType.PHYSICS),
			new Subject("Biology 1", "A-BIOLGY-106", SubjectType.BIOLOGY),
			new Subject("Biology 2", "U-BIOLGY-206", SubjectType.BIOLOGY),
			new Subject("Computer Science", "B-COMPSCI-107", SubjectType.COMPUTER_SCIENCE),
			new Subject("Medicine", "B-MEDICN-108", SubjectType.MEDICINE)};

	public static Subject getSubject(String ID) {
		for (Subject subject : subjectList) {
			if (subject.getID().equals(ID)) {
				return subject;
			}
		}

		return null;
	}

	public static boolean has(String ID) {
		for (Subject subject : subjectList) {
			if (subject.getID().equals(ID)) {
				return true;
			}
		}

		return false;
	}

	public static String[] getIDs() {
		String[] IDs = new String[subjectList.length];

		for (int i = 0; i < subjectList.length; i++) {
			IDs[i] = subjectList[i].getID();
		}

		return IDs;
	}
}
