package io.github.keebler17.keebasm;

public enum InstructionType {
	NOP, // 0x00
	LDA, // 0x01
	LDB, // 0x02
	LDO, // 0x03
	STA, // 0x04
	STB, // 0x05
	STO, // 0x06
	ADD, // 0x07
	OUT, // 0x08
	CJMP, // 0x09
	JMP, // 0x0A
	CMP, // 0x0B
	CCMP, // 0x0C
	JC, // 0x0D
	JG, // 0x0E
	JL, // 0x0F
	JE, // 0x10
	JZ, // 0x11
	JNZ, // 0x12
	HLT, // 0x13
	EXIT, // 0x14
	DB, // not a real instruction, just there for the assembler
}
